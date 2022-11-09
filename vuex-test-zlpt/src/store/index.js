import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    isRegister: false,
    studentInfo: {},
  },
  getters: {
    isRegister: (state) => {
      return state.isRegister;
    },
    studentInfo: (state) => {
      return state.studentInfo;
    },
  },
  mutations: {
    setIsRegister(state, isRegister) {
      state.isRegister = isRegister;
    },
    setStudentInfo(state, studentInfo) {
      state.studentInfo = studentInfo;
    },
  },
  actions: {
  },
  modules: {
  }
});
