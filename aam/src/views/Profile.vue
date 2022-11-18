<template>
    <div>
        <v-card>
            <v-card-text>
                <p class="text-h4" >Your Profile</p>
                <v-row>
                    <v-col cols="4" class="font-weight-bold">Name</v-col>
                    <v-col cols="8" class="font-weight-bold">{{userInfo.name}}</v-col>

                    <v-col cols="4" class="font-weight-bold">Mail Address</v-col>
                    <v-col cols="8" class="font-weight-bold">{{userInfo.mail}}</v-col>

                    <v-col cols="4" class="font-weight-bold">Age</v-col>
                    <v-col cols="8" class="font-weight-bold">{{userInfo.age}}</v-col>

                    <v-col cols="4" class="font-weight-bold">Gender</v-col>
                    <v-col cols="8" class="font-weight-bold">{{userInfo.gender}}</v-col>

                    <v-col cols="4" class="font-weight-bold">Self Introduction</v-col>
                    <v-col cols="8" class="font-weight-bold">{{userInfo.selfIntro}}</v-col>               
                </v-row>
            </v-card-text>
        </v-card>
        
    </div>
  
</template>

<script>
export default {
    name: "profile",
    data(){
        return{
            userInfo: {},
        };
    },
    created(){
    this.isRegister = this.$store.state.isRegister;
    this.userInfo = this.$store.state.userInfo;
    this.$store.watch(
      () => {
        return this.$store.state.userInfo;
      },
      (newVal, oldVal) =>{
        this.userInfo = newVal;
      },
      {
        deep: true,
      }
      );   
    },
    methods: {},

}
</script>

<style>

</style>