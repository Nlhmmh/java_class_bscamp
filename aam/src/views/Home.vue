<template>
  <html>
    <head></head>
    <body>
        <div>
            <h1>Welcome to home screen</h1>
            <P>Always be ready at {{pm }}</P>
            <!-- <h2>{{count.data().count.toString()=="8" ? "My Number is 8": "Default" }}</h2> -->
            <p>My name is {{username}}</p>
            <MyCount></MyCount>
        </div>
    </body>
  </html>
</template>

<script>
import MyCount from "../components/Count.vue";

export default {
    name: "home",
    components: {
        MyCount
    },

    data(){
        return {
            username: "ki ki",
            pm: "4:58PM",
            count: MyCount,
            isBtnDisable: false,
        };
    },

    created(){
        console.log(MyCount.data().count);
    },

    methods: {
        
    }
}
</script>


<style>

</style>