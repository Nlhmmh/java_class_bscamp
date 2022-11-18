import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import About from '../views/About.vue'
import Tutorial from '../views/Tutorial.vue'
import Profile from '../views/Profile.vue'
import Register from '../views/Register.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/about',
    name: 'about',
    component: About
  },
  {
    path: '/register',
    name: 'register',
    component: Register
  },
  {
    path: '/profile',
    name: 'profile',
    component: Profile
  },
  {
    path: '/tutorial',
    name: 'tutorial',
    component: Tutorial
  },
 
]

// const router = new VueRouter({
//   routes
// })

const router = new VueRouter({
  mode: "history",
  routes: routes
})

export default router
