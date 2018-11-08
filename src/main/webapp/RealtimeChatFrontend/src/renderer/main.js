import Vue from 'vue';
import axios from 'axios';
import localStorage from 'electron-json-storage';

import Argon from './argon/plugins/argon-kit';
import App from './App';
import router from './router';
import store from './store';

if (!process.env.IS_WEB) Vue.use(require('vue-electron'));
Vue.use(Argon);
Vue.http = Vue.prototype.$http = axios;
Vue.localStorage = Vue.prototype.$localStorage = localStorage;
Vue.config.productionTip = false;

/* eslint-disable no-new */
new Vue({
    components: { App },
    router,
    store,
    template: '<App/>',
}).$mount('#app');
