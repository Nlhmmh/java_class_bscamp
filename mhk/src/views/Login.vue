<template>
    <v-container>
     <v-card class="elevation-6 mt-10" >
         <v-card-text class="mt-12">
                                     <h4 class="text-center">
                                         Login to Your Account
                                     </h4>
                                     <h6 class="text-center grey--text">
                                         Log in to your account so you can continue building<br>and editing your onboarding flows
                                     </h6>
                                     <v-row justify="center">
                                         <v-col cols="12" sm="8">
                                             <v-text-field label="Email" outlined dense color="blue" autocomplete="false" class="mt-16" v-model="email"/>
                                             
                                             <p>{{email}}</p>
                                             <v-text-field label="Password" outlined dense color="blue" autocomplete="false" type="password"  v-model="password"/>
                                             <p>{{password}}</p>
 
                                             <v-btn color="blue" dark block tileb @click="login()">Log in</v-btn>
                                             <h5 class="text-center grey--text mt-4 mb-3">Or Log in using</h5>
                                             <div class="d-flext justify-space-between align-center mx-10 mb-11">
                                                 <v-contaier depressed outlined color="grey">
                                                     <v-icon color="blue">mdi-gmail</v-icon>
                                                 </v-contaier>
                                                 <v-contaier depressed outlined color="grey">
                                                     <v-icon color="blue">mdi-facebook</v-icon>
                                                 </v-contaier>
                                                 <v-contaier depressed outlined color="grey">
                                                     <v-icon color="blue">mdi-twitter</v-icon>
                                                 </v-contaier>
                                             </div>
                                         </v-col>
                                     </v-row>
                                 </v-card-text>
 
             </v-card>
 
    </v-container>
 </template>
 
 <script>
 import router from '@/router';
 
 export default{
     data:()=>({
         step:1,
         email:"",
         password:""
     }),
     props:{
         source:String
     },
     created(){
         console.log("Open login ")
     },
 
     methods:{
       login(){
         router.push({path:"/home"})
       }
     }
 }
 </script>