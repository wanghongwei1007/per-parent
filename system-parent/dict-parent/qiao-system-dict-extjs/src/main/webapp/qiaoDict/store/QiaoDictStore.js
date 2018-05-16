/**
 * 字典数据仓库
 *
 * @author chenyanxu
 */
Ext.define('kalix.qiao.qiaoDict.store.QiaoDictStore', {
    extend: 'kalix.store.BaseStore',
    model: 'kalix.dict.model.DictModel',
    alias: 'store.qiaoDictStore',
    xtype: 'qiaoDictStore',
    storeId: 'qiaoDictStore',
    proxyUrl: CONFIG.restRoot + '/camel/rest/qiao/dicts'
});