<template>
    <div>
        <h1>Welcom to Home Screen</h1>
        <p>Khin Chan Myae Thu</p>
        <!--1,Test <Interpolation-->
            <!--2,Data Binding-->
            <!--3,Event Binding-->
        <h3>{{userName}}</h3>
        <h3>{{ count = 5 ? "Is 5":"default" }}</h3>
        <a></a>
        <button :disabled="isBtnDisable" @click="countUp()">Count Up</button>
        <MyButton></MyButton>
    </div>
</template>

<script>
import MyButtonVue from '../components/MyButton.vue';
export default {
   name: "Home" ,
   //Use components
   components : {MyButtonVue},
   //Variables
   data (){
    return{
        userName : "Mg Mg",
        count:0,
        isBtnDisable:false,
    }
   },
    created(){
            console.log("Opended home screen")
    },

   methods:{

   countUp(num=0){
    this.count++;
   }
}
}
</script>

<style >
      button{
        padding: 30px;
        color :blueviolet;
        text-decoration: underline;
      }

      my-p{
        padding : 20px;
        color :blue;
      }
</style>