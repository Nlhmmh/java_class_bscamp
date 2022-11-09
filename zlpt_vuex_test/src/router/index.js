import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from "../views/Home.vue"
import About from "../views/About.vue"
import Register from "../views/Register.vue"
import Profile from "../views/Profile.vue"
import Calculator from "../views/Calculator.vue"

Vue.use(VueRouter)

const routes = [

  {
    path: "/",
    name: "home",
    component: Home,
  },

  {
    path: "/about",
    name: "about",
    component: About,
  },

  {
    path: "/register",
    name: "register",
    component: Register,
  },

  {
    path: "/profile",
    name: "profile",
    component: Profile,
  },

  {
    path: "/calculator",
    name: "calculator",
    component: Calculator,
  }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
