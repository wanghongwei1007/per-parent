/**
 *
 * Dict extJs use new base dict components
 * @author chenyanxu
 */
Ext.define('kalix.qiao.qiaoDict.Main', {
    extend: 'kalix.dict.Main',
    requires: [
        'kalix.dict.view.DictGrid',
        'kalix.dict.view.DictSearchForm',
        'kalix.qiao.qiaoDict.store.QiaoDictStore'
    ]
});