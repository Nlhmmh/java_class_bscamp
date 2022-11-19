<template>
  <v-app>
    <v-main>
      <!--Navi bar-->
      <v-app-bar color="deep-purple accent-4" dark>
        <v-btn class="text-h5" text @click="gotoScreen('/')">Home</v-btn>
      <v-spacer></v-spacer>
      <v-btn v-show="!isRegister"  @click="gotoScreen('/register')">Register</v-btn>
      <v-btn v-show="isRegister" text @click="gotoScreen('/profile')">Profile</v-btn>
      <v-btn text @click="goToScren('/about')">about</v-btn>
      <v-btn v-show="isRegister" text @click="OnClickLogOut">LogOut</v-btn>
      </v-app-bar>
       <!--Screen-->
      <v-container>
        <router-view/></v-container>
      
     
    </v-main>
  </v-app>
</template>
<script>
export default {
  name : "App",
  data:()=>({
    isRegister:false,
  }),
  created(){
    this.isRegister= this.$store.state.isRegister;
        this.$store.watch(
            () => {
                return this.$store.state.isRegister;
            },
            (newVal,oldVal)=>{
                this.userInfo = newVal;
            },
            {
                deep:true
            }
        )
  },
  methods:{
    OnClickLogOut(){
      this.$store.commit("setIsRegister",false);
      this.$.commit("setUserInfo",{})
      
      if(this.$router.currentRoute.path != "/"){
        this.goToScren("/");
      }
      
    },
    gotoScreen(screenPath){
      if(this.$router.push({path:screenPath}));
    }

  }
}

</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
