package com.kalix.qiao.genealogy.api.dto;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by wangpeng on 2018/7/7
 * Excel导出数据封装
 */
public class ExcelDTO implements Serializable {
    private List<String> fields;// 行数
    private List<String> columns;// 列标题
    private List<Map<String, Object>> records; // 数据，Map格式 key：fields里的
    private List<Boolean> totals; // 是否统计？
    private String title;// 第一行合并单元格的大标题
    private String template;// 已存在的模板，null，其他的没试过
    private Boolean rownumber;// 是否输出行号
    private String suffix;// 导出文件类型

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    public List<Map<String, Object>> getRecords() {
        return records;
    }

    public void setRecords(List<Map<String, Object>> records) {
        this.records = records;
    }

    public List<Boolean> getTotals() {
        return totals;
    }

    public void setTotals(List<Boolean> totals) {
        this.totals = totals;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public Boolean getRownumber() {
        return rownumber;
    }

    public void setRownumber(Boolean rownumber) {
        this.rownumber = rownumber;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
