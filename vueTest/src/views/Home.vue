<template>
  <div>
    <h1>Welcome to Home Screen</h1>
    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Nesciunt recusandae, quam suscipit molestiae optio eius consectetur consequuntur, veniam provident iure illo tenetur molestias inventore corporis iusto maxime ipsam non laudantium!</p>
    <p class="my-p">{{ userName }}</p>
    <h3>{{ count }}</h3>
    <h3>{{ count == 5?"Is 5" : "Default"}}</h3>
    <button @click="countUp()" :disabled="isBtnDisable">Count Up</button>
   <MyButtonVue></MyButtonVue>
  </div>
</template>

<script>
import MyButtonVue from '@/components/MyButton.vue';

export default {

//Screen name
name:"home",

//Use Components
components:{
    MyButtonVue,
},

//Variables
data(){
    return{
        userName:"Mg Mg",
        count: 0,
        isBtnDisable:false,
    };
},

//Run when open first screen
created(){
    console.log("Opened Home Screen");
},

//Methods
methods: {
    // countUp(num = 0){
    //     num++;
    //     console.log(num);
    //     return num;
    // },
    countUp(){
        this.count++;
    },
},
};
</script>

<style scoped>
button {
    padding: 20px;
    color: green;
    text-decoration: underline;
    font-weight: bold;
}

.my-p{
    background-color: skyblue;
}
</style>