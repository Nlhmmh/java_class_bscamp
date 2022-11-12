<template>
  <div>
    <v-container>
    <!--Form-->
    <v-form ref="registerForm">
        <v-text-field 
        v-model="name" 
        label="Name" 
        placeholder="Mg Mg"
        :rules="[v => !!v || 'Required']"
        ></v-text-field>

        <v-text-field 
        v-model="gmail" 
        label="Gmail" 
        placeholder="name@gmail.com"
        :rules="[v => !!v || 'Required']"
        ></v-text-field>

        <v-text-field 
        v-model="age" 
        label="Age" 
        placeholder="e.g 20" 
        type="number"
        :rules="[v => !!v || 'Required', 
        v => (v && v > 20 )|| 'Age must be greater than 20',
        v => (v && v < 60 )|| 'Age must be less than 60']"
        ></v-text-field>

        <v-select
        v-model="gender"
        :items="['male', 'female']"
        label="Gender"
        :rules="[v => !!v || 'Required']"
        ></v-select>

        <v-textarea 
        v-model="selfIntroduction"
        clearable
        clear-icon="mdi-close-circle"
        label="Self Introduction"
        counter
        ></v-textarea>

        <v-btn 
        class="mt-6"
        @click="onClickReg"
        color="success"
        >Register</v-btn>


    </v-form>
    </v-container>
  </div>
</template>


<script>
export default {
    name:'register',

    data(){
        return{
            name:"",
            gmail:"",
            age:"",
            gender:"",
            selfIntroduction:""  
        };
    },

    methods:{
        onClickReg(){
            if(this.$refs.registerForm.validate()){
                console.log(this.name);
                console.log(this.gmail);
                console.log(this.age);
                console.log(this.gender);
                console.log(this.selfIntroduction);

                //store in vuex State
                this.$store.commit("setIsRegister", true);
                this.$store.commit("setUserInfo",{
                    name: this.name,
                    gmail:this.gmail,
                    age:this.age,
                    gender:this.gender,
                    selfIntroducton:this.selfIntroduction
                });

                
                //go to screen
                this.$router.push({path:"/"})
            }else{
               console.log("Validate Failed"); 
            }
            
        }
    },
}
</script>


<style>

</style>