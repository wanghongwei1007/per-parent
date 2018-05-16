/**
 * 字典数据仓库
 *
 * @author chenyanxu
 */
Ext.define('kalix.qiao.qiaoDict.store.QiaoDictCacheStore', {
    extend: 'kalix.store.BaseStore',
    model: 'kalix.dict.model.DictModel',
    alias: 'store.qiaoDictCacheStore',
    xtype: 'qiaoDictCacheStore',
    storeId: 'qiaoDictCacheStore',
    pageSize: 0,
    autoLoad: true,
    singleton: true,
    proxyUrl: CONFIG.restRoot + '/camel/rest/qiao/dicts/cache/list'
});