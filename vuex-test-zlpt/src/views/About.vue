<template>
  <div>
    <v-container>
        <h1 class="text-center">About</h1>
        <v-divider></v-divider>
        <v-card class="mt-6">
            <v-card-title>{{ count }}</v-card-title>
            <v-card-subtitle>Click These Buttons To Toggle Count</v-card-subtitle>
            <v-card-actions>
                <v-btn color="primary" elevation="3" @click="increaseCount">
                    Increase
                </v-btn>
                <v-btn color="error" elevation="3" @click="decreaseCount">
                    Decrease
                </v-btn>
            </v-card-actions>
        </v-card>
    </v-container>
  </div>
</template>

<script>
export default {
    name: "about",
    data() {
        return {
            count: 0,
        }
    },
    methods: {
        increaseCount() {
            this.count++;
        },
        decreaseCount() {
            this.count--;
        }
    }
}
</script>

<style>

</style>