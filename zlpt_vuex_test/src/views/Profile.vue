<template>
  <div>
    <v-container>
        <h2 class="text-center">{{ studentInfo.name }} Profile</h2>
        <v-divider></v-divider>
        <v-row class="mt-6">
            <v-col cols="3"></v-col>
            <v-col cols="6">
                <v-card elevation="12">
                    <v-row>
                        <v-col cols="6" class="text-center">Full Name :</v-col>
                        <v-col cols="6"><h4>{{ studentInfo.name }}</h4></v-col>
                    </v-row>

                    <v-row>
                        <v-col cols="6" class="text-center">Email :</v-col>
                        <v-col cols="6"><h4>{{ studentInfo.email }}</h4></v-col>
                    </v-row>

                    <v-row>
                        <v-col cols="6" class="text-center">Phone :</v-col>
                        <v-col cols="6"><h4>{{ studentInfo.phone }}</h4></v-col>
                    </v-row>

                    <v-row>
                        <v-col cols="6" class="text-center">Gender :</v-col>
                        <v-col cols="6"><h4>{{ studentInfo.gender }}</h4></v-col>
                    </v-row>

                    <v-row>
                        <v-col cols="6" class="text-center">Uni Year :</v-col>
                        <v-col cols="6"><h4>{{ studentInfo.year }}</h4></v-col>
                    </v-row>

                    <v-row>
                        <v-col cols="6" class="text-center">Major :</v-col>
                        <v-col cols="6"><h4>{{ studentInfo.major }}</h4></v-col>
                    </v-row>
                </v-card>
            </v-col>
            <v-col cols="3"></v-col>
        </v-row>
    </v-container>
  </div>
</template>

<script>
export default {
    name: "profile",
    data() {
        return {
            studentInfo: {},
        }
    },
    created() {
        this.studentInfo = this.$store.state.studentInfo;
        this.$store.watch(
        () => {
            return this.$store.state.studentInfo;
        },
        (newVal, oldVal) => {
            this.studentInfo = newVal;
        },
        {
            deep: true,
        }
        );
    },


}
</script>

<style>

</style>