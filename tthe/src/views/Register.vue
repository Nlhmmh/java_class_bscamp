<template>
    
  <div>
    <!-- Form -->
    <v-form ref="registerForm">
        <v-text-field 
        v-model="name" 
        label="Name" 
        placeholder="Mg Mg"
        :rules="[(v) => !!v || 'Required']" required>
        </v-text-field>

        <v-text-field 
        v-model="mail" 
        label="Mail Address" 
        placeholder="test@gmail.com"
        :rules="[(v) => !!v || 'Required']" required>
        </v-text-field>

        <v-text-field 
        v-model="age" 
        label="Age" 
        placeholder="10"
        type="number"
        :rules="[(v) => !!v || 'Required',
                (v) => (v && v > 0) || 'Age must be greater than 0',
                (v) => (v && v <= 100) || 'Age must be less than 100',]" 
        required>
        </v-text-field>

        <v-select 
        v-model="gender" 
        label="Gender"
        :items="['unknown','male', 'female']"
        required>
        </v-select>

        <v-textarea
        v-model="selfIntro"
        label="Self Introduction"
        clearable
        counter
        >
        <!-- :rules="[(v) => (v && v.length <= 200) || 'Age must be less than 200',]"  -->
        </v-textarea>

        <v-btn class="mt-5" color="success" @click="onClickRegisterBtn">Register</v-btn>

    </v-form>
    <!-- <p>{{ name }}</p> -->
  </div>
</template>

<script>
export default {
    name: "register",
    data(){
        return {
            name: "test",
            mail: "test@gmail.com",
            age: 10,
            gender: "male",
            selfIntro: "Test",
        };
    },

    methods:{
        onClickRegisterBtn(){
            
            if(this.$refs.registerForm.validate()){
                // console.log("Register success");
                // console.log(this.name);
                // console.log(this.mail);
                // console.log(this.age);
                // console.log(this.gender);
                // console.log(this.selfIntro);

                // Store in Vuex state
                // mutations
                this.$store.commit("setIsRegister", true);
                this.$store.commit("setUserInfo", 
                {
                    name: this.name,
                    mail: this.mail,
                    age: this.age,
                    gender: this.gender,
                    selfIntro: this.selfIntro,
                }
                );

                // go to Screen
                this.$router.push({ path: "/" });
            }else{
                console.log("Register fail");
            }
        }
    },
}
</script>

<style>

</style>