<template>
  <div>
    <!-- Form -->
    <v-form ref="registerForm">
      <!-- Name Text Field -->
      <v-text-field
        v-model="name"
        label="Name"
        placeholder="Mg Mg"
        :rules="[(v) => !!v || 'Required']"
        required
      ></v-text-field>

      <!-- Mail Address Text Field -->
      <v-text-field
        v-model="mail"
        label="Mail Address"
        placeholder="test@gmail.com"
        :rules="[(v) => !!v || 'Required']"
        required
      ></v-text-field>

      <!-- Age Text Field -->
      <v-text-field
        v-model="age"
        label="Age"
        placeholder="10"
        type="number"
        :rules="[
          (v) => !!v || 'Required',
          (v) => (v && v > 0) || 'Age must be greater than 0',
          (v) => (v && v <= 200) || 'Age must be less than 100',
        ]"
        required
      ></v-text-field>

      <!-- Gender Select -->
      <v-select
        v-model="gender"
        :items="['unknown', 'male', 'female']"
        label="Gender"
        :rules="[(v) => !!v || 'Required']"
        required
      >
      </v-select>

      <!-- Self Introduction Textarea -->
      <v-textarea
        v-model="selfIntro"
        label="Self Introduction"
        clearable
        counter
      >
      </v-textarea>

      <v-btn class="mt-5 width-100" color="success" @click="onClickRegisterBtn"
        >Register</v-btn
      >
    </v-form>
  </div>
</template>

<script>
export default {
  name: "register",
  data() {
    return {
      name: "",
      mail: "",
      age: 0,
      gender: "",
      selfIntro: "",
      // name: "Mg Mg",
      // mail: "test@gmail.com",
      // age: 10,
      // gender: "male",
      // selfIntro: "Test",
    };
  },
  methods: {
    onClickRegisterBtn() {
      if (this.$refs.registerForm.validate()) {
        // console.log("Validate Successful");
        // console.log(this.name);
        // console.log(this.mail);
        // console.log(this.age);
        // console.log(this.gender);
        // console.log(this.selfIntro);

        // Store in Vuex State
        this.$store.commit("setIsRegister", true);
        this.$store.commit("setUserInfo", {
          name: this.name,
          mail: this.mail,
          age: this.age,
          gender: this.gender,
          selfIntro: this.selfIntro,
        });

        // Go to Screen
        this.$router.push({ path: "/" });
      } else {
        console.log("Validate Failed");
      }
    },
  },
};
</script>

<style></style>
