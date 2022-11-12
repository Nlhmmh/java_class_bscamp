<template>
  <v-app>
    <v-app-bar
      color="green"
      dense
      elevation="4" max-height="60px">
      <v-btn text class="text-h5" @click ="goToScreen('/')">Home</v-btn>
      <v-spacer></v-spacer>
      <v-btn  v-show="!isRegister" text @click ="goToScreen('/register')">Register</v-btn>
      <v-btn v-show="isRegister" text @click ="goToScreen('/profile')">Profile</v-btn>
      <v-btn text @click ="goToScreen('/about')">About</v-btn>
      <v-btn v-show="isRegister" text @click="onClickLogout">Logout</v-btn>

    </v-app-bar>
    <v-main>
      <router-view/>
    </v-main>
  </v-app>
</template>

<script>
export default {
  name: 'App',

  data: () => ({
    isRegister :false
  }),
  
  created(){
    this.isRegister = this.$store.state.isRegister;
    this.$store.watch(
      ()=> {
        return this.$store.state.isRegister;
      },
      (newVal, oldVal) =>{
        this.isRegister = newVal;
      },
      {
        deep:true
      }
    )
  },
  methods:{
    onClickLogout(){
      this.$store.commit("setIsRegister", false);
      this.$store.commit("setUserInfo",{});

      //go to  home screeen
      if(this.$router.currentRoute.path !="/"){
        this.goToScreen("/");
      }
      
    },



    goToScreen(screenPath){
      this.$router.push({path: screenPath})
    }
  }
};
</script>

<style scoped>
</style>