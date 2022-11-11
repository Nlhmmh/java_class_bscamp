import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '@/views/Home';
import Login from '@/views/Login';
import Register from '@/views/Register';
import Profile from '@/views/Profile';
import About from '@/views/About'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'register',
    component: Register
  },
{
  path:'/profile',
  name:'profile',
  component:Profile
},
{
  path:'/home',
  name:'home',
  component:Home
}
,
{
  path: '/about',
  name: 'about',
  component: About
}
  
]

const router = new VueRouter({
  routes
})

export default router
