import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    isRegister:false,
    userInfo:{},
    isCourse:false,
    courseInfo:{},
  },
  getters: {
    isRegister:(state) => {
      return state.isRegister;
    },
    userInfo:(state) => {
      return state.userInfo;
    },
    isCourse:(state) => {
      return state.isCourse;
    },
    courseInfo:(state) => {
      return state.courseInfo;
    },
  },
  mutations: {
    setIsRegister(state,isRegister){
      state.isRegister = isRegister;
    },
    setUserInfo(state,userInfo){
      state.userInfo = userInfo;
    },
    setIsCourse(state,isCourse){
      state.isCourse = isCourse;
    },
    setCourseInfo(state,courseInfo){
      state.courseInfo = courseInfo;
    },
  },
  actions: {
  },
  modules: {
  }
})
