<template>
    <div>
        <h1>Welcome to Home Screen</h1>
        <!--
          1. Text Interporation
          2. Data Binding
          3. Event Binding
        -->
        <p class="my-p">{{userName}}</p>
        <p>{{count}}</p>
        <button @click="countUp()" :disabled="isButtonDisable">Count Up</button>
        <MyButtonVue></MyButtonVue>
    </div>
</template>

<script>
import MyButtonVue from '@/components/MyButton.vue';
export default {
    // Screen Name
    name:"Tutorial",
    
    // Use components
    components:{
        MyButtonVue
    },

     // Varaiables
    data(){
        return{
            userName:"Mg Mg",
            count:0,
            isButtonDisable:true,
        };
    },

    // Run when first open screen
    created() {
        console.log("Open when first");
    },

    // Methods
    methods:{
        // countUp(num = 0){
        //   num++;
        // return num;
        // },
        countUp(){
            this.count++;
        }
    },
}
</script>

<style>
     button{
          color:blue;
          margin-bottom: 10px;
      }
      .my-p{color:blue;}
</style>