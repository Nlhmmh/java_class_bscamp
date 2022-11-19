<template>
    <div>
        <v-from ref="registerFrom">
            <v-text-field
            v-model="name"
            label="Name"
            placeholder="Mg Mg"
            :rules="[(v) => !! v || 'Required']"
            Required
            ></v-text-field>

           <v-text-field
            v-model="mail"
            label="Mail Address"
            placeholder="kkk@gmil.com"
            :rules="[(v) => !! v || 'Required']"
            required
            ></v-text-field>

            <v-text-field
            v-model="age"
            label="Age"
            placeholder="10"
            type="number"
            :rules="[(v) => !! v || 'Required',
            (v)=>(v && v > 0) || 'Age must be greater than 0',
            (v)=>(v && v <= 200) || 'Age must be less than 0']"
            Required>
            </v-text-field>

            <v-select 
            v-model="gender"
            :items="['unknown','male','female']"
            label="Gender"
            :rules="[(v)=> !! v || 'Required']"
            required
            ></v-select>

            <v-textarea 
            v-model="selfIntro"
            label="Self Introduction"
            clearable
            counter
            ></v-textarea>
            <v-btn class="mt-5 width-100" color="access" @click="OnClickRegisterBtn">Register</v-btn>
        </v-from>
    </div>
</template>
<script>
export default {
    name:"register",
    data(){
        name:"";
        mail:"";
        age:0;
        gender:"";
        selfIntro:""
    },
    methods:{
        OnClickRegisterBtn(){
            if(this.$refs.registerFrom()){
                this.$store.commit("setIsRegister",true);
                this.$store.commit("setUserInfo",{
                    name:this.name,
                    mail:this.mail,
                    age:this.age,
                    gender:this.gender,
                    selfIntro:this.selfIntro,
                });
                this.$router.push({path:"/"})
            }else{
                console.log("Validate Failed")
            }
        }
    }
}
</script>
<style>

</style>