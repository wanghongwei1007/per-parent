/**
 * 字典数据仓库
 *
 * @author chenyanxu
 */
Ext.define('kalix.qiao.qiaoSetting.store.QiaoSettingStore', {
    extend: 'kalix.store.BaseStore',
    model: 'kalix.setting.model.SettingModel',
    alias: 'store.qiaoSettingStore',
    xtype: 'qiaoSettingStore',
    storeId: 'qiaoSettingStore',
    proxyUrl: CONFIG.restRoot + '/camel/rest/qiao/settings'
});