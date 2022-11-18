<template>
  <v-app>
    <v-main>
      <v-app-bar color="green accent-4" dark> 
          <v-btn text class="text-h5" @click="goToScreen('/')" >Home</v-btn>
          <v-spacer></v-spacer>
          <v-btn text v-show = "!isRegister" @click = "goToScreen('/register')" >Register</v-btn>
          <v-btn text v-show = "isRegister" @click = "goToScreen('/profile')" >Profile</v-btn>
          <v-btn text @click = "goToScreen('/about')" >About</v-btn> 
          <v-btn text v-show = "isRegister"  @click = "onClickLogout" >Logout</v-btn> 
      </v-app-bar>
      <v-container>
        <router-view/>
      </v-container>     
    </v-main>  
  </v-app>
</template>

<script>

export default {
  name: 'App',

  data: () => ({
    isRegister: false,
    screenPath: "",
  }),
  created(){
    this.isRegister = this.$store.state.isRegister;
    this.$store.watch(
      () => {
        return this.$store.state.isRegister;
      },
      (newVal, oldVal) =>{
        this.isRegister = newVal;
      },
      {
        deep: true,
      }
      );
   
    },
    methods: {
      onClickLogout(){
          this.$store.commit("setIsRegister",false);
          this.$store.commit("setUserInfo",{}); 
          if(this.$router.currentRoute.path !="/"){
            this.$router.push({ path: "/"}) 
          }
          
        },
        goToScreen(screenPath){
          this.$router.push({ path: screenPath})
        }
    }

  };

</script>

