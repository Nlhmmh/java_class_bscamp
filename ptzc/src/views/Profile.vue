<template>
  <div>
    <v-card>
        <v-card-text>
            <p class="text-5">Your Profile</p>
            <v-row>
                <!-- sm="4" md="4" lg="3" xl="2" -->
                <v-col cols="4" class="font-weight-bold">Name</v-col>
                <!-- sm="8" md="8" lg="9" xl="10" -->
                <v-col cols="8">{{userInfo.name}}</v-col>

                <v-col cols="4" class="font-weight-bold">Mail Address</v-col>
                <v-col cols="8">{{userInfo.mail}}</v-col>

                <v-col cols="4" class="font-weight-bold">Age</v-col>
                <v-col cols="8">{{userInfo.age}}</v-col>

                <v-col cols="4" class="font-weight-bold">Gender</v-col>
                <v-col cols="8">{{userInfo.gender}}</v-col>

                <v-col cols="4" class="font-weight-bold">Self Introduction</v-col>
                <v-col cols="8">{{userInfo.selIntro}}</v-col>
            </v-row>
        </v-card-text>
    </v-card>
  </div>
</template>

<script>
export default {
    name:"profile",

    data(){
        return {
            userInfo:{
                name:"Mg Mg",
            },
        };
    },

    created(){
        this.userInfo = this.$store.state.userInfo;
        this.$store.watch(
        () => {
          return this.$store.state.userInfo;
        },
        (newVal, oldVal) => {
          this.userInfo = newVal;
        },
        {
          deep:true,
        }
      );
    },

    methods:{

    },
}
</script>

<style>

</style>