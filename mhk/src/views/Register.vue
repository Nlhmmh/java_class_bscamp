<template>
    <div>
        <v-form ref="registerForm">
            <v-text-field v-model="name" label="Name" 
            placeholder="Mg Mg" 
            required
            :rules="[(v)=> !!v || 'Required']"
            >
            </v-text-field>

            <v-text-field v-model="email" label="Email" :rules="[(v)=> !!v || 'Required']" placeholder="abc@gmail.com" required>
            </v-text-field>

            <v-text-field v-model="password" label="Password" :rules="[(v)=> !!v || 'Required']" placeholder="123456" required>
            </v-text-field>

            <v-select v-model="gender" :items="['unknown', 'male', 'female']" label="Gender" required></v-select>

            <v-textarea v-model="about" label="Introductiion" clearable counter=""></v-textarea>
        
            <v-btn class="mt-5 width-100" color="success" @click="onRegister()">Register</v-btn>
        
        </v-form>
    </div>
</template>

<script>
 export default{
    name:"register",
    data(){
        return {
            name:"",
            email:"",
            password:"",
            gender:"unknown",
            about:""
        }
    },
    methods:{
        onRegister(){
            if(this.$refs.registerForm.validate()){
                this.$store.commit("setIsRegister",true);
                this.$store.commit("setUserInfo",{
                    name:this.name,
                    email:this.email,
                    password:this.password,
                    gender:this.gender,
                    about:this.about
                });
                this.$router.push({path: "/profile"})
            }
        }
    }
 }
</script>