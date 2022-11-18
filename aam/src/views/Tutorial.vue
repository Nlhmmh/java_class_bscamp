<template>
    <v-container>
       <v-app>
            <v-app-bar>    
                <v-app-bar-title>
                    Home
                </v-app-bar-title>
            </v-app-bar> 
        </v-app>
    </v-container>
   
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