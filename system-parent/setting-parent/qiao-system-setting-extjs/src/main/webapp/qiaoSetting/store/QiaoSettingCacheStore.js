/**
 * 字典数据仓库
 *
 * @author chenyanxu
 */
Ext.define('kalix.qiao.qiaoSetting.store.QiaoSettingCacheStore', {
    extend: 'kalix.store.BaseStore',
    model: 'kalix.setting.model.SettingModel',
    alias: 'store.qiaoSettingCacheStore',
    xtype: 'qiaoSettingCacheStore',
    storeId: 'qiaoSettingCacheStore',
    pageSize: 0,
    autoLoad: true,
    singleton: true,
    proxyUrl: CONFIG.restRoot + '/camel/rest/qiao/settings/cache/list'
});