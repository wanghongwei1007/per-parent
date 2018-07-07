package com.kalix.qiao.genealogy.biz;

import com.csvreader.CsvWriter;
import com.google.gson.Gson;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.impl.biz.GenericBizServiceImpl;
import com.kalix.middleware.excel.api.biz.IExcelService;
import com.kalix.qiao.genealogy.api.biz.IClansmanBeanService;
import com.kalix.qiao.genealogy.api.biz.IGenealogyBeanService;
import com.kalix.qiao.genealogy.api.biz.IGenerationBeanService;
import com.kalix.qiao.genealogy.api.dao.IGenealogyBeanDao;
import com.kalix.qiao.genealogy.api.dto.ExcelDTO;
import com.kalix.qiao.genealogy.entities.ClansmanBean;
import com.kalix.qiao.genealogy.entities.GenealogyBean;
import com.kalix.qiao.genealogy.api.dto.ClansmanDTO;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2018/5/13.
 */
public class GenealogyBeanServiceImpl extends GenericBizServiceImpl<IGenealogyBeanDao, GenealogyBean> implements IGenealogyBeanService {

    private IClansmanBeanService clansmanBeanService;
    private IGenerationBeanService generationBeanService;
    private IExcelService excelService;

    @Override
    public void writeSVCFile(long id){
//        try {
//            // 创建CSV写对象
//            List<ClansmanBean> ls=new ArrayList<>();
//            for (int i = 0; i <1000; i++) {
//                ClansmanBean s=new ClansmanBean();
//                s.setName("小帅"+i);
//                s.setSex("男"+i);
//                s.setHealth("良好");
//                s.setHomeaddress("dsafksdlk");
//                ls.add(s);
//            }
//            //写入临时文件
//            File tempFile = File.createTempFile("vehicle", ".csv");
//            CsvWriter csvWriter = new CsvWriter(tempFile.getCanonicalPath(),',', Charset.forName("UTF-8"));
//            // 写表头
//            long s= System.currentTimeMillis();
//            System.err.println();
//            String[] headers = {"姓名","年龄","编号","性别"};
//            csvWriter.writeRecord(headers);
//            for (ClansmanBean stu : ls) {
//                csvWriter.write(stu.getName());
//                csvWriter.write(stu.getSex());
//                csvWriter.write(stu.getHealth());
//                csvWriter.write(stu.getHomeaddress());
//                csvWriter.endRecord();
//            }
//            csvWriter.close();
//            long e=System.currentTimeMillis();
//
//            System.err.println(e-s);
//
//            /**
//             * 写入csv结束，写出流
//             */
//            java.io.OutputStream out = response.getOutputStream();
//            byte[] b = new byte[10240];
//            java.io.File fileLoad = new java.io.File(tempFile.getCanonicalPath());
//            response.reset();
//            response.setContentType("application/csv");
//            response.setHeader("content-disposition", "attachment; filename=vehicleModel.csv");
//            long fileLength = fileLoad.length();
//            String length1 = String.valueOf(fileLength);
//            response.setHeader("Content_Length", length1);
//            java.io.FileInputStream in = new java.io.FileInputStream(fileLoad);
//            int n;
//            while ((n = in.read(b)) != -1) {
//                out.write(b, 0, n); //每次写入out1024字节
//            }
//            in.close();
//            out.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public JsonData queryForTree() {
        List<GenealogyBean> genealogyBeanList = dao.getAll();
        List<ClansmanDTO> list = new ArrayList<>();
        JsonData jsonData = new JsonData();
        if (genealogyBeanList.size() > 0) {
            for (GenealogyBean g : genealogyBeanList) {
                ClansmanDTO j = new ClansmanDTO();
                j.setModelId(g.getId());
                j.setLabel(g.getGenealogyname());
                list.add(j);
            }
            jsonData.setData(list);
            jsonData.setTotalCount((long) list.size());
        } else {
            jsonData.setTotalCount((long) list.size());
        }
        return jsonData;
    }

    @Override
    public JsonData findById(long id) {
        GenealogyBean genealogyBean = dao.get(id);
        String[] strings = genealogyBean.getGenealogysite().split(",");
        List<String> stringList = Arrays.asList(strings);
        JsonData j = new JsonData();
        j.setData(stringList);
        genealogyBean.setDefaultOption(j);
        List<GenealogyBean> list = new ArrayList<>();
        list.add(genealogyBean);
        JsonData jsonData = new JsonData();
        jsonData.setData(list);
        jsonData.setTotalCount((long) list.size());
        return jsonData;
    }

    @Override
    public JsonData deleteById(long id) {
        dao.remove(id);
        clansmanBeanService.deleteByGenealogyId(id);
        generationBeanService.DeleteByGenealogyId(id);
        JsonData jsonData = new JsonData();
        return jsonData;
    }

    @Override
    public Map<String, Object> exportExcel(long id) {
        List<ClansmanBean> list = dao.find("select c from ClansmanBean c where c.genealogynameid = ?1", id);
        List<String> columns = getColums();
        ExcelDTO excelDTO = new ExcelDTO();
        excelDTO.setFields(columns);
        excelDTO.setColumns(columns);
        excelDTO = getRecords(excelDTO, list, columns);
        excelDTO.setTitle(null);
        excelDTO.setTemplate(null);
        excelDTO.setRownumber(false);
        excelDTO.setSuffix(".csv");
        Gson gson = new Gson();
        String jsonStr = gson.toJson(excelDTO);
        jsonStr = jsonStr.replaceAll("\"", "\'");
        Map<String, Object> map = excelService.GetExcelFromJson(jsonStr);
        return map;
    }

    private ExcelDTO getRecords(ExcelDTO excelDTO, List<ClansmanBean> list, List<String> fields) {
        List<Map<String, Object>> records = new ArrayList<>();
        List<Boolean> totals = new ArrayList<>();
        for(ClansmanBean clansmanBean : list) {
            Map<String, Object> map = new HashMap<>();
            for (int i = 0; i < fields.size(); i++) {
                switch (i) {
                    case 0 :map.put(fields.get(i), clansmanBean.getName());break; // 姓名
                    case 1 :map.put(fields.get(i), clansmanBean.getSex());break; // 性别
                    case 2 :map.put(fields.get(i), "配偶");break; // 配偶
                    case 3 :map.put(fields.get(i), "父亲");break; // 父亲
                    case 4 :map.put(fields.get(i), "祖父");break; // 祖父
                    case 5 :map.put(fields.get(i), "母亲");break; // 母亲
                    case 6 :map.put(fields.get(i), "世代，数字");break; // 世代 数字
                    case 7 :map.put(fields.get(i), clansmanBean.getGradeid());break; // 字辈
                    case 8 :map.put(fields.get(i), "排行，数字");break; // 排行 数字
                    case 9 :map.put(fields.get(i), "兄弟");break; // 兄弟
                    case 10 :map.put(fields.get(i), "姐妹");break; // 姐妹
                    case 11 :map.put(fields.get(i), "子女");break; // 子女
                    case 12 :map.put(fields.get(i), new SimpleDateFormat("yyyy-MM-dd").format(clansmanBean.getBirth()));break; // 出生日期
                    case 13 :map.put(fields.get(i), new SimpleDateFormat("yyyy-MM-dd").format(clansmanBean.getDatetime()));break; // 纪念日期
                    case 14 :map.put(fields.get(i), clansmanBean.getHomeaddress()+","+clansmanBean.getDetailedAddress());break; // 家庭地址
                    case 15 :map.put(fields.get(i), clansmanBean.getNecropolis()+","+clansmanBean.getNecropolisAddress());break; // 葬于
                    case 16 :map.put(fields.get(i), "123456789");break; // 通讯
                    case 17 :map.put(fields.get(i), "汉族");break; // 民族
                    case 18 :map.put(fields.get(i), "");break; // 出生地址
                    case 19 :map.put(fields.get(i), clansmanBean.getMonicker());break; // 字
                    case 20 :map.put(fields.get(i), "");break; // 号
                    case 21 :map.put(fields.get(i), "籍贯");break; // 籍贯
                    case 22 :map.put(fields.get(i), "曾用名");break; // 曾用名
                    case 23 :map.put(fields.get(i), clansmanBean.getMatrimony());break; // 婚姻
                    case 24 :map.put(fields.get(i), "职业");break; // 职业
                    case 25 :map.put(fields.get(i), clansmanBean.getEducation());break; // 学历
                    case 26 :map.put(fields.get(i), "其他信息");break; // 其他信息
                    case 27 :map.put(fields.get(i), "继嗣");break; // 继嗣
                    case 28 :map.put(fields.get(i), "0");break; // 统计 数字，模板为0
                    case 29 :map.put(fields.get(i), "备注");break; // 备注
                }
            }
            records.add(map);
        }
        for (int i = 0; i < fields.size(); i++) {
            totals.add(false);
        }
        excelDTO.setRecords(records);
        excelDTO.setTotals(totals);
        return excelDTO;
    }

    private List<String> getColums() {
        List<String> columns = new ArrayList<>();
        columns.add("姓名");
        columns.add("性别");
        columns.add("配偶");
        columns.add("父亲");
        columns.add("祖父");
        columns.add("母亲");
        columns.add("世代");
        columns.add("字辈");
        columns.add("排行");
        columns.add("兄弟");
        columns.add("姐妹");
        columns.add("子女");
        columns.add("出生日期");
        columns.add("纪念日期");
        columns.add("家庭地址");
        columns.add("葬于");
        columns.add("通讯");
        columns.add("民族");
        columns.add("出生地址");
        columns.add("字");
        columns.add("号");
        columns.add("籍贯");
        columns.add("曾用名");
        columns.add("婚姻");
        columns.add("职业");
        columns.add("学历");
        columns.add("其他信息");
        columns.add("继嗣");
        columns.add("统计");
        columns.add("备注");
        return columns;
    }


    public void setClansmanBeanService(IClansmanBeanService clansmanBeanService) {
        this.clansmanBeanService = clansmanBeanService;
    }

    public void setGenerationBeanService(IGenerationBeanService generationBeanService) {
        this.generationBeanService = generationBeanService;
    }

    public void setExcelService(IExcelService excelService) {
        this.excelService = excelService;
    }
}
