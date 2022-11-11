<template>
 
    <div>
      <v-container>
        <v-card class="pa-5 mt-10" elevation="4" max-width="300">
          <v-img
            max-height="150"
            src="https://cdn.pixabay.com/photo/2015/04/19/08/32/marguerite-729510__340.jpg"
          ></v-img>
          <v-card-title>About This Home page</v-card-title>
          <v-card-actions>
            <v-btn color="primary" elevation="10" >See More</v-btn>
            <v-btn disabled> Disabled </v-btn>
          </v-card-actions>
        </v-card>
      </v-container>
    </div>
    
  </template>

<script>
import router from '@/router';

export default{
    data:()=>({
    
    }),
    
    created(){
        console.log("Open home ")
    },

    methods:{
       
    }
}
</script>