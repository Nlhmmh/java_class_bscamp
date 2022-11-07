<template>
  <div>
    <v-form ref="registerForm">
        <!-- Name Textfield -->
        <v-text-field 
            v-model="name"
            label="Name"
            placeholder="Mg Mg"
            :rule="[(v) => !!v || 'Required']"
            required
        ></v-text-field>
        <!-- Mail Textfield -->
        <v-text-field 
            v-model="mail"
            label="Mail Address"
            placeholder="test@gmail.com"
            :rule="[(v) => !!v || 'Required']"
            required
        ></v-text-field>
        <!-- Age Textfield -->
        <v-text-field 
            v-model="age"
            label="Age"
            placeholder="10"
            type="number"
            :rule="[
                (v) => !!v || 'Required',
                (v) => (v && v>0) || 'Age must be greater than 0',
                (v) => (v && v<=200) || 'Age must be greater than 100',
            ]"
            required
        ></v-text-field>
        <!-- Gender Select -->
        <v-select
            v-model="gender"
            label="Gender"
            :items="['unknown','male','female']"
            :rule="[(v) => !!v || 'Required']"
            required
        ></v-select>
         <!-- Self Introduction Textarea -->
        <v-textarea
            v-model="selIntro"
            label="Self Introduction"
            clearable
            counter
        ></v-textarea>
        <v-btn class="mt-5" color="success" @click="onClickRegisterBtn">Register</v-btn>
    </v-form>
  </div>
</template>

<script>
export default {
    name:"register",
    data(){
        return {
            name:"",
            mail:"",
            age:0,
            gender:"unknown",
            selIntro:"",
        };
    },
    methods:{
        onClickRegisterBtn(){
            if(this.$refs.registerForm.validate()){
                // Store in vuex state <=> mutation
                this.$store.commit("setIsRegister",true);
                this.$store.commit("setUserInfo",{
                    name:this.name,
                    mail:this.mail,
                    age:this.age,
                    gender:this.gender,
                    selIntro:this.selIntro,
                });

                // Go to screen
                this.$router.push({path:"/"});
            }else{
                console.log("Validate Failed!");
            }
        },
    },
}
</script>

<style>

</style>