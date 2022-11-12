<template>
  <div>
    <v-container>
        <p class="text-h5" style="color: blue;">Your Profile</p>
    <v-card>
        <v-card-text>
            <v-row class="aa" >
                <v-col cols="4">Name</v-col>
                <v-col cols="8">{{userInfo.name}}</v-col>
            </v-row>

            <v-row class="bb">
                <v-col cols="5" >Gmail</v-col>
                <v-col cols="7">{{userInfo.gmail}}</v-col>
            </v-row>

            <v-row class="cc">
                <v-col cols="6" >Age</v-col>
                <v-col cols="6">{{userInfo.age}}</v-col>
            </v-row>

            <v-row class="dd">
                <v-col cols="7">Gender</v-col>
                <v-col cols="5">{{userInfo.gender}}</v-col>
            </v-row>

            <v-row class="ee"> 
                <v-col cols="8">selfIntroduction</v-col>
                <v-col cols="4">{{userInfo.selfIntroduction}}</v-col>
            </v-row>

        </v-card-text>
    </v-card>
</v-container>
  </div>
</template>

<script>
export default {
    name:'profile',

    data(){
        return{
            userInfo:{
            },
        }
    },

    created(){
        this.userInfo =this.$store.state.userInfo;
        this.$store.watch(
        ()=> {
            return this.$store.state.userInfo;
        },
        (newVal, oldVal) =>{
            this.userInfo = newVal;
        },
        {
            deep:true
        }
        )
    },

    methods:{

    }
}
</script>

<style>
.aa{
    color: blueviolet;
    font-style: italic;
    background-color: black;
}

.bb{
    color: red;
    font-family: Arial, Helvetica, sans-serif;
    background-color: chartreuse;
}

.cc{
    color:blue;
    font-display: unset;
    background-color: bisque;
}

.dd{
    color: greenyellow;
    font-kerning: auto;
    background-color: aqua;
}

.ee{
    color: black;
    font-family: Arial, Helvetica, sans-serif;
    background-color: darkmagenta;
}
</style>