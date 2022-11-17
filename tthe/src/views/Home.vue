<template>
    <div>
        <h1>Welcome to Home Screen</h1>
        <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Doloribus aliquam soluta debitis delectus in, laboriosam iusto, accusantium aut explicabo repellendus praesentium! Impedit eos nobis temporibus est molestiae nihil veritatis aliquid!</p>
        <!-- 1. Text Interpolation -->
        <p class="my-p">{{ userName }}</p>
        <h3>{{ count }}</h3>
        <h3>{{ count == 5 ? "is 5" : "default" }}</h3>
        <!-- 2. Data binding-->
        <!-- 3. Event binding-->
        <button :disabled="isBtnDisabled" @click="countUp()">countUp</button>

        <MyButtomVue></MyButtomVue>
    </div>
</template>

<script>
import MyButtomVue from '@/components/MyButtom.vue';


export default {
    //Screen Name
    name: "home",

    //Use compontents
    components: {
        MyButtomVue,
    },

    //Variables
    data(){
        return{
            userName: "Su Su",
            count: 0,
            isBtnDisabled: false,
        };
    },

    //Run when first time of open screen
    created(){
        console.log("Opened Home Screen");
    },

    //methods
    methods:{
        // countUp(num = 0){
        //     num++;
        //     console.log(num);
        //     return num;
        // },
        countUp(){
            this.count++;
        },
    },

    
}
</script>

<style scoped>
    button{
        padding: 30px;
        color: blue;
        text-decoration: underline;
    }
    .my-p{
        color: yellow;
        padding: 10px;
    }
</style>