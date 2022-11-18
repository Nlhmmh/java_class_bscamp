<template>
    <h1> Welcome to Home {{userInfo.name}}</h1>
  
</template>

<script>
export default {
    name:"Home",
    data(){
        return{
            userInfo: "",
        };
    },
    created(){
    this.userInfo = this.$store.state.userInfo;
    this.$store.watch(
      () => {
        return this.$store.state.userInfo;
      },
      (newVal, oldVal) =>{
        this.userInfo = newVal;
      },
      {
        deep: true,
      }
      );   
    },
}
</script>

<style>

</style>