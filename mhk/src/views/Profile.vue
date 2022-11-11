<template>
    <div>
        <v-card>
            <p class="text-h5">Your Profile</p>
            <v-row>
                <v-col cols="4" class="font-weight-bold">Name</v-col>
                <v-col cols="8">{{userInfo.name}}</v-col>

                <v-col cols="4" class="font-weight-bold">Email</v-col>
                <v-col cols="8">{{userInfo.email}}</v-col>

                <v-col cols="4" class="font-weight-bold">Gender</v-col>
                <v-col cols="8">{{userInfo.gender}}</v-col>

                <v-col cols="4" class="font-weight-bold">Infro</v-col>
                <v-col cols="8">{{userInfo.about}}</v-col>
            </v-row>
        </v-card>
    </div>
</template>

<script>
export default{
    name:"profile",

    data(){
        return{
            userInfo:{
                
            }
        }
    },

    created(){
        this.userInfo=this.$store.state.userInfo;
        this.$store.watch(  
            ()=> {
                return this.$store.state.userInfo
            },
            (newVal,oldVal)=>{
                this.userInfo=newVal;
            },
            {
                deep:true,
            }


            
            );
          
        
    }
}
</script>