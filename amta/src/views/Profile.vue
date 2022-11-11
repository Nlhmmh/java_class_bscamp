<template>
  <div>
    <v-card>
      <v-card-text>
        <p class="text-h5">Profile Information</p>
        <v-row>
          <v-col cols="4" class="font-weight-bold">Name</v-col>
          <v-col cols="8">{{userInfo.name}}</v-col>
          <v-col cols="4" class="font-weight-bold">Email</v-col>
          <v-col cols="8">{{userInfo.email}}</v-col>
          <v-col cols="4" class="font-weight-bold">Age</v-col>
          <v-col cols="8">{{userInfo.age}}</v-col>
          <v-col cols="4" class="font-weight-bold">Gender</v-col>
          <v-col cols="8">{{userInfo.gender}}</v-col>
          <v-col cols="4" class="font-weight-bold">Language</v-col>
          <v-col cols="8">{{userInfo.language}}</v-col>
          <v-col cols="4" class="font-weight-bold">Self Intro</v-col>
          <v-col cols="8">{{userInfo.selfIntro}}</v-col>
        </v-row>
      </v-card-text>
    </v-card>
  </div>
</template>
<script>
export default {
  name: "profile",

  data() {
    return {
      userInfo: {},
    };
  },

  created() {
    this.userInfo = this.$store.state.userInfo;

    this.$store.watch(
      () => {
        return this.$store.state.userInfo;
      },
      (newVal, oldVal) => {
        this.userInfo = newVal;
      },
      {
        deep: true,
      }
    );
  },

  methods: {},
};
</script>
