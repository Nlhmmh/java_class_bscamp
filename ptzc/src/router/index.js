import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import About from '../views/About.vue'
import Tutorial from '@/views/Tutorial.vue'
import Register from '@/views/Register.vue'
import Profile from '@/views/Profile.vue'
import Course from '@/views/Course.vue'
import CourseView from '@/views/CourseView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'about',
    component: About
  },
  {
    path: '/tutorial',
    name: 'tutorial',
    component: Tutorial
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
    path: '/course',
    name: 'course',
    component: Course
  },
  {
    path: '/courseview',
    name: 'courseview',
    component: CourseView
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
