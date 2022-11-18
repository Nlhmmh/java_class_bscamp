<template>
    <div>
        <v-form ref="registerfrm" v-model="registerfrm" >
            <v-text-field label="Name" placeholder="Mg Mg" v-model="name" 
            :rules = "[(v) => !!v || 'Required',]" required ></v-text-field>

            <v-text-field label="E-Mail" placeholder="abcd@abcd.com" 
            :rules="emailRules" v-model="mail" required ></v-text-field>

            <v-text-field label="Age" v-model="age" type="number"
            :rules = "[
            (v) => !!v || 'Required',
            (v) => (v && v > 0 || 'Age must be greater than 0'),
            (v) => (v && v < 100 || 'Age must be less than 100')
            ] " required ></v-text-field>

            <v-select label="Gender" :items="['unknown','male','female']" v-model="gender"  
            :rules = "[(v) => !!v || 'Required',]" required ></v-select>

            <v-textarea label="Self Introduction" v-model="selfIntro" required ></v-textarea>

            <v-btn  color="success" @click="registerbtn" >Register</v-btn>
         </v-form>
    </div>
    
  
</template>

<script>

export default {
    name:"register",
    data(){ 
        return{
            name: "",
            mail: "",
            age: 0,
            gender: "",
            selfIntro: "",
            emailRules: [ 
                (v) => !!v || 'Required',
                (v) => /.+@.+\..+/.test(v) || 'E-mail must be valid'
            ]
        };
    },
    methods: {
        registerbtn(){
            if(this.$refs.registerfrm.validate()){

               this.$store.commit("setIsRegister",true);

               this.$store.commit("setUserInfo",{
               name: this.name,
               mail: this.mail,
               age: this.age,
               gender: this.gender,
               selfIntro: this.selfIntro,  
               });
             
            }
            else{
                console.log("fail");
            }
            this.$router.push({ path: "/"})
        },
    }
}
</script>

<style>

</style>