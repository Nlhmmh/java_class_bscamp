import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    isRegister: false,
    userInfo: {},
  },
  getters: {
    isRegister: (state) => {
      return isRegister;

    },
    userInfo: (state) => {
      return userInfo;

    }
  },
  mutations: {
    setIsRegister(state,isRegister){
      state.isRegister = isRegister;
    },
    setUserInfo(state,userInfo){
      state.userInfo = userInfo;
    }
  },
  actions: {
  },
  modules: {
  }
})
