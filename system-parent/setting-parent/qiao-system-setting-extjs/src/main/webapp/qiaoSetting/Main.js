/**
 *
 * Setting extJs use new base setting components
 * @author chenyanxu
 */
Ext.define('kalix.qiao.qiaoSetting.Main', {
    extend: 'kalix.setting.Main',
    requires: [
        'kalix.setting.view.SettingGrid',
        'kalix.setting.view.SettingSearchForm',
        'kalix.qiao.qiaoSetting.store.QiaoSettingStore'
    ]
});