# RxJava2+Retrofit2+OKHttp3+ButterKnife+Room+Glide+SweetAlertDialog  Demo

Demo是本人入门学习上述框架后做的一个简单的练习，Demo本身上比较简单，但是却确实用上了上述的框架，也算是一次实践了。

框架的简单介绍：

RxJava2+Retrofit2+OKHttp3：目前比较流行的网络请求组合了（好吧，其实也流行好久了）

ButterKnife：比较好用的View依赖注入框架，准确的说，他实际上不太算是依赖注入框架，因为它仅仅只能帮助注入View。
            但是由于它使用方便再加上Android ButterKnife zelezny这样的懒人插件的辅助，使得这款框架得到很
            多像我这样的懒人程序员的喜爱
            
Room：一款google出品的数据库框架，使用确实很方便

Glide：就像他的名字一样，这款图片加载框架真的是很棒了

SweetAlertDialog：一款好看的对话框框架

 总体流程:
 
 * 控件的依赖注入使用ButterKnife，使用RXJava+Retrofit发起网络请求,
 
 * 获取到数据之后使用Room存入本地Sqlite数据库中,之后从数据库中读出来显示
 
 * 到ListView上，图片加载模块使用Glide来处理，最后将数据从数据库中删除.
 
 Demo做了哪些工作：(除了框架必须要实现的代码)
 
 *Demo使用到了ListView来展示数据，所以少不了适配器得实现
 
 *使用单列模式来把SweetAlertDialog封装成一个Utils文件，使得使用SweetAlertDialog只需要一行代码
 
 *使用单列模式来把Glide封装成一个Utils文件，使得使用Glide只需要一行代码
 
 
 入门级别的Demo,如果对您有帮助的话，欢迎star!!!
