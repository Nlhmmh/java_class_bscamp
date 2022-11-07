<template>
  <div>
    <v-card>
        <v-card-text>
            <p class="text-5">Course View</p>
            <v-row>
                <v-col cols="4" class="font-weight-bold">ID</v-col>
                <v-col cols="8">{{courseInfo.id}}</v-col>
                <v-col cols="4" class="font-weight-bold">Subject</v-col>
                <v-col cols="8">{{courseInfo.subject}}</v-col>
                <v-col cols="4" class="font-weight-bold">Description</v-col>
                <v-col cols="8">{{courseInfo.description}}</v-col>
            </v-row>
        </v-card-text>
    </v-card>
  </div>
</template>

<script>
export default {
    name:"courseview",

    data(){
        return {
            courseInfo:{
                subject:"",
            },
        };
    },

    created(){
        this.courseInfo = this.$store.state.courseInfo;
        this.$store.watch(
        () => {
          return this.$store.state.courseInfo;
        },
        (newVal, oldVal) => {
          this.courseInfo = newVal;
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