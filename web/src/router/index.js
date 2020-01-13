import Vue from 'vue'
import Router from 'vue-router'

const originalPush = Router.prototype.push
Router.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}

Vue.use(Router)

var router = new Router({
  routes: [
    {
      path: '/',
      name: 'Index',
    },
    {
      path: '/historyRiver',
      name: 'HistoryRiver',
      component:  resolve => require(['@/views/historyRiver/index'],resolve)
    }
  ]
});


//路由守卫
router.beforeEach(function(to,from,next){
  next();
})



export default router;

