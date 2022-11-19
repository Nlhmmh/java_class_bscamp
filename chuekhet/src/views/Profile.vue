<template>
    <div>
            <v-card>
                <v-card-text>
                    <p class="text-h5">Your Profile</p>
                    <v-row>
                        <v-col cols="4"  class="font-weight-bold"> Name</v-col>
                        <v-col cols="11" >{{userInfo.name}}</v-col>
                        <v-col cols="4"  class="font-weight-bold"> Mail Address</v-col>
                        <v-col cols="11" >{{userInfo.mail}}</v-col>
                        <v-col cols="4"  class="font-weight-bold"> Age</v-col>
                        <v-col cols="11">{{userInfo.age}}</v-col>
                        <v-col cols="4"  class="font-weight-bold"> Gender</v-col>
                        <v-col cols="11">{{userInfo.gender}}</v-col>
                        <v-col cols="4"  class="font-weight-bold"> SelfInfo</v-col>
                        <v-col cols="11">{{userInfo.selfIntro}}</v-col>
                    </v-row>
                </v-card-text>
            </v-card>
    </div>
</template>
<script>
export default {
    name : "profile",
    data(){
        return{
            userInfo:{
                name:"Su Su",
            },
        }
    },
    created(){
        this.userInfo = this.$store.state.userInfo;
        this.$store.watch(
            () => {
                return this.$store.state.userInfo;
            },
            (newVal,oldVal)=>{
                this.userInfo = newVal;
            },
            {
                deep:true
            }
        )
    }
}
</script>
<style>

</style>