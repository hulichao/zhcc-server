# zhcc
基于vue(element ui) + ssm + shiro 的权限框架
---
# 引言
## 心声
现在的Java世界，各种资源很丰富，不得不说，从分布式，服务化，orm,再到前端控制，权限等等玲琅满目，网上有句话说，语言框架迭代太快了，我学不动了，不如回去搬砖吧。程序搞起来很容易，就是有点头冷。
<div align="center"> <img src="http://p94g7wqy4.bkt.clouddn.com/zhcc/content/touleng.jpg" width="400"/> </div><br>

## 程序员的两大世界难题
### 重复轮子
语言框架迭代太快，没错，就简单来说高级语言就有几十种，虽然流行的就那么几种，语言就是重复之一，从语言想表达的作用上来看，都是为了操作计算机，我想未来计算机语言的前景可能是语言一体化，当然，这是个很漫长的路，相信一些语言的创造者，当初也是对某语言不满意，然后就去改造，但是其实绝大部分还是重复的，这一方面，我深有体会，当初，仅仅为了更好地学习MVC框架原理，觉得最好的学习就是重写它，最后，比如[hulichao_framework](https://github.com/hulichao/hulichao_framework.git)下面的oliver就是结果的残品，只是实现了基本的从页面到处理端的映射，以及处理返回，其实想想也比较简单，尤其是原理，就是页面与控制器更好地处理与映射，当然完美重写，我没有这样干，现在流行的开源mvc框架已经很多了，另外一个就是简单重构过orm框架[hulichao_framework](https://github.com/hulichao/hulichao_framework.git)下面的yBatis，实现了什么呢，就是数据库与Java程序之间的相互映射，同时约定固定方法开头的可以不需要写sql语句，想说明什么问题呢，其一，我在重复造轮子，当然在这个学习的过程中，我还是收获蛮大的，即使现有框架不能满足部分功能，但是重新改造它代价如果比较高，也不建议，其二，学习的过程就是先原理，再接口，再注释代码的过程，就像前面的框架从一开始，我想实现的主要功能明白了，然后参考主要的原理，设计接口，最后写代码实现，岂有难载。

### 沟通问题
第二个问题其实不仅涉及到人与人，也涉及到了机器与人的关系，产品经理说，我想做一台挖掘机来炒菜，挖掘机根据最好的优化路线行驶，就跟现在的无人车一样，同时设备齐全，能根据主人的口味推荐出菜系，这样既可以保持其原有功用，又可以作为私家小助手，用最优雅的方式做出最美味的菜，不就是炒菜么，对于很多人来说也不复杂，开个挖掘机相信也不需要太多知识，还有做推荐算法的，请一些相关领域专家，应该也不是很大问题，但是整个流程组合起来就比较费劲了，互联网就是这样，把生活中各种各种实实在在的问题用互联网的思维来实现，那么有什么问题呢，那就是沟通，各个专业人员之间的沟通，设计者的想法与实现者的想法的互动，机器与人的互动。听起来这是个段子，或者科幻电影的情节，嗯，其实确实是。对于程序员，与同事的沟通，与产品经理沟通，需求是什么，能实现成怎么样，就是看整个团队的契合度吧。

## 建议
理解原理有用，但不要重复造轮子，不要重复造轮子，不要重复造轮子,宁愿去github找一圈找到基本合适的轮子改造，也不要为了装逼写自己轮子，否则会很难受，至于沟通，不得不说就是个难解，所以出来了面向接口设计，面向接口编程，这样的方式比肥仔快乐水更自然。<div align="center"> <img src="http://p94g7wqy4.bkt.clouddn.com//zhcc/content/feizai1.jpg" width="400"/> </div><br>
<div align="center"> <img src="http://p94g7wqy4.bkt.clouddn.com//zhcc/content/feizai2.jpg" width="400"/> </div><br>

---
# 正题
随着前后端分离项目的热潮，前端各大框架的，前后端沟通部分也成了问题，之前服务端渲染的页面生成到前端来，现在前后端可能是两个服务器，一些技术的迁移，本框架的权限部分的设计思想，借鉴了前端大牛的想法，也有传统后端的设计方案，抛砖引玉，做个桥梁，实现前后端分离的权限的设计，代码仅供参考，思路仅供参考，相信优秀的你写自己的代码，用自己的思想会更为贴切，方便。
最终即具有统一响应结构、 前后台数据流转机制(HTTP消息与Java对象的互相转化机制)、统一的异常处理机制、参数验证机制、Cors跨域请求机制以及鉴权机制
前端设计：采用Vue的element ui ，对于前端设计者来说，应该很好理解源码。
后端设计：shiro + ssm + redis存储jwt
交互方式：前端存储jwt，在访问后端时携带，这也是唯一交互验证方式。
前期工作：设计符合需求的vue模板，路由，资源，角色，用户其中对应关系也可从数据表中体现出来
## 写在前
实际的应用中，其一是要求用户简单地进行注册登录，其二是对其授权，附带的有session管理和加密，所以诞生了shiro这款框架，而前后端分离的趋势，使得shiro更好地应用于前端更有实际意义，而目前像vue类似的前端框架也很热门，同时正好接触到了vue，所以为了适应要求，抽象出来基于前后端完全分离的权限框架。
另外，一般认为权限只能是后端来做，但是前后端分离的情况下呢？这样岂不是很没有意义。况且关于vue的权限控制在业界相对没有主流的方案，百度一下，这方面的资料也不多，基本都很零散。
前端地址：
后端地址：

## 设计思路
基本想法就是，用到Vuex 和 Vue Router  前者用来做状态控制，后者绑定路由，这样权限可以直接对应到组件上，某个用于只能访问某个组件，而不用将每个组件都加上权限控制，重要的是还有单点登录。
所以抛砖引玉，写一个通用框架，（至少是通用想法）具体可以模块化来可插拔就ok 了。
非动态路由的问题是只能在拿到权限之后初始化Vue实例，因此必须把登陆页从SPA中剥离出来做成一个独立的页面，用户登录/退出操作需要在两个url之间跳转，体验略差。

另一种做法是直接用所有路由实例化应用，当用户登录拿到权限后再通过元素操作隐藏越权菜单，这时用户还可以手动输入地址访问越权页面，因此还需要给路由加beforeEach钩子来限制路由访问，路由钩子本身会增加一定的性能压力，而且实例化即注册所有路由也会使前端加载冗余的路由组件。
本系统采用的在初始路由注册首页和登录页，并在拿到token后得到权限，然后在实例化Vue实例。路由代码如下：
```javascript
const router = new Router({
  routes: [
    {
      path: '/login',
      name: "login",
      component: LoginView,
      meta: { requiresAuth: false }
    },{
      path: '/index',
      redirect: '/',
      meta: { requiresAuth: true }
    }
  ]
});
generateIndexRouter();

// 验证token，存在才跳转
router.beforeEach((to, from, next) => {
  let token = sessionStorage.getItem('token')
  if(to.path === '/') {
    if(!token) {
      next({
				path: '/login',
				query: { redirect: to.fullPath }
      })
      return
    }
  }

	if(to.meta.requiresAuth) {
		if(token) {
			next()
		} else {
			next({
				path: '/login',
				query: { redirect: to.fullPath }
			})
		}
	} else {
		next()
	}
});

router.afterEach((to, from) => {
  // 设置面包屑
  let breadCrumbItems = []
  let homePageCrumb = {
    title: '首页',
    to: '/'
  }
  breadCrumbItems.push(homePageCrumb)
  if(to.meta.nameFullPath) {
    let fullPathSplit = to.meta.nameFullPath.split('/')
    fullPathSplit.forEach(( item, index ) => {
      let routerBreadCrumb = {
        title: item,
        to: (index == fullPathSplit.length - 1 ? to.path : '')
      }
      breadCrumbItems.push(routerBreadCrumb)
    });
  }
  // 更新到state
  router.app.$store.dispatch('setBreadcurmbItems', breadCrumbItems)
})

// 生成首页路由
function generateIndexRouter() {
  if (!sessionStorage.routers) {
    return
  }
  let indexRouter = {
    path: "/",
    name: "/",
    component: resolve => require(['@/views/home/index'], resolve),
    children: [
      ...generateChildRouters()
    ]
  }
  router.addRoutes([indexRouter])
}

// 生成嵌套路由（子路由）
function generateChildRouters() {
  let routers = JSON.parse(sessionStorage.routers)
  let childRouters = []
  for(let router of routers) {
    if(router.code != null) {
      let routerProps = JSON.parse(router.properties)
      let childRouter = {
        path: router.url,
        name: router.code,
        component: resolve => require(['@/views/' + router.code + '/index'], resolve),
        meta: { routerId: router.id, requiresAuth: routerProps.meta.requiresAuth, nameFullPath: routerProps.nameFullPath }
      }
      childRouters.push(childRouter)
    }
  }
  return childRouters
}

export default router;

```

### 前后端数据格式约定
既然是restful风格，必然有通用返回状态的类，遵循网上开源原则，一类继承hashmap这样达到可以返回任意的数据，通用的数据就是code.msg.data这些，如果有分页会另外加分页，还有一种是，data.msg.state(code).token + 分页类型的数据如：
```
"data": {
    "list": null,
    "pagebar": {
      "page": 1,
      "total": 2,
      "limit": 10
    }
  },
 "msg": "error",
  "state": 0,
  "is_redirect": true,
  "redirect_url": "http://qq.com",
  "token": null
```
本项目考虑到后期的扩展性，用到了第一类，其中实现了常用的失败和成功的状态码及其响应,类名设计为Result，位于zhcc-common下面，一般性地是封装到ResponseEntity中返回。
### 前后端数据接口约定
分别对应http协议的get/put/post/delete方法，后端权限是:read/:update/:create/:delete
```java
case "get":
    permissionString += ":read";
    break;
case "put":
    permissionString += ":update";
    break;
case "post":
    permissionString += ":create";
    break;
case "delete":
    permissionString += ":delete";
```
### 验证部分
用的是com.baidu.unbiz.fluentvalidator.ValidationError 而不是hibernateValidator 减轻服务端编程等的压力。直接在controller里面验证,最后封装到Result的fail方法里面返回。
## 权限的设计
权限的控制主要分为4大类，主要是基于RBAC原理。
路由，资源，角色，用户
路由级别和组件级别可控制

## 过程设计
1.权限设计
2.异常设计
3.字典和其他接口设计 
4.前后的通讯设计==
## 说明
vue.js官网是最好的教程，vue.js官网是最好的教程，vue.js官网是最好的教程。不信的话，咱走着瞧！
## 怎么用？
一份 demo、一个入门指南、一个 API 列表，还有一个测试
## 捐赠（Donation）
觉得不错的话，赏呗咖啡呗，一杯不行半杯也可以诶，如果进来fork一下下，star一下下再好不过啦。
<div align="center"> <img src="http://p94g7wqy4.bkt.clouddn.com//common/pay/weChatPay.png" width="400"/> 
<img src="http://p94g7wqy4.bkt.clouddn.com//common/pay/zhiFuPay.jpg" width="400"/> </div><br>

## 参考

- 参考资料1：[vue 权限前端设计](https://refined-x.com/2017/11/28/Vue2.0%E7%94%A8%E6%88%B7%E6%9D%83%E9%99%90%E6%8E%A7%E5%88%B6%E8%A7%A3%E5%86%B3%E6%96%B9%E6%A1%88/
)
- 参考资料2：csdn https://edu.csdn.net/course/play/4983/undefined
- 参考资料3：开源框架 https://gitee.com/zhocuhenglin/dp-security/tree/master/dp-shiro/src/main/java/net/chenlin/dp/shiro
- 参考资料4：vue 官网
- 参考资料5：vue 权限控制 https://github.com/OneWayTech/vue-auth-solution
## 刻意练习
说明一点，从学习本身来说并不是难事，比如读一本书，学会用一个框架，等等，即使零基础到熟练，所花费的时间和精力也不会很多，而整个技能栈却又是这样一点一滴积累起来的，那些看起来洋洋得意的大神，背后都少不了"肮脏",为什么你就不可以，因为你想速成，你想一夜之间掌握所有的技能，所以现在的各种速成，比如21天学会从删库到跑路的书籍很流行，其实哪有捷径，只有警记：自律可以改变生活，成长在于坚持与积累。从刻意练习这里可以学到的是，学会学习，我们作为编程儿，无论哪种形式要记得编程->反馈->修正->重新整理学习。个人博客地址http://hulichao.top 