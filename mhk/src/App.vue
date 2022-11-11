

<template>
  <v-app>
    <v-main>
      <v-app-bar color="blue" dark>
        <v-btn class="text-h5" text @click="goToScreen('/home')"> Home </v-btn>
        <v-spacer></v-spacer>
        <v-btn v-show="!isRegister" text @click="goToScreen('/')">
          Register
        </v-btn>
        <v-btn v-show="isRegister" text @click="goToScreen('/profile')">
          Profile
        </v-btn>
        <v-btn text @click="goToScreen('/about')"> About </v-btn>
        <v-btn v-show="isRegister" text @click="onClickLogout"> Logout </v-btn>
      </v-app-bar>
      <v-container>
        <router-view />
      </v-container>
      
    </v-main>
  </v-app>
</template>

<script>

export default {
  name: 'App',

  data: () => ({
    isRegister: false,
    
  }),

  created(){
    this.isRegister=this.$store.state.isRegister;
    this.$store.watch(
      ()=> {
        return this.$store.state.isRegister;
      },
      (newVal,oldVal)=>{
        this.isRegister=newVal;
      },{
        deep:true,
      }
    );
  },

  methods:{
    goToScreen(screenPath){
      this.$router.push({path: screenPath});
    },
    onClickLogout(){
      this.$store.commit("setIsRegister",false);
      this.$store.commit("setUserInfo",[]);

      if(this.$router.currentRoute.path!= "/"){
        this.goToScreen("/");
      }
    }
  }
};
</script>

<style scoped>
.my-nav-title{
  font-weight: bold;
}
</style>
