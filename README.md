# Hellio
RxJava2+Retrofit2+ButterKnife+Room Demo
 * 总体流程:控件的依赖注入使用ButterKnife，使用RXJava+Retrofit发起网络请求,
 * 获取到数据之后使用Room存入本地Sqlite数据库中,之后从数据库中读出来显示
 * 到ListView上，图片加载模块使用Glide来处理，最后将数据从数据库中删除.
