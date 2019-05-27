<template>
    <v-container>
        <v-layout style="margin-bottom: 50px; margin-top: 20px;">
            <h1>ALL USERS</h1>
        </v-layout>
        <user-table :key="users.length" :users="users"></user-table>
    </v-container>
</template>

<script>
    import UserTable from "../components/UserTable.vue";
    import http from '../services/http.js'

    export default {
        name: "UsersPage",
        components: {UserTable},
        data: function () {
            return {
                childDataLoaded: false,
                users: []
            }
        },
        mounted() {
            let self = this;
            http.get('/users').then(function (response) {
                self.users = response.data;
                console.log(response);
                self.childDataLoaded = true;
            }).catch(function (error) {
                console.log(error);
            })

        }
    }
</script>

<style scoped>

</style>