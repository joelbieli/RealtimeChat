import Vue from 'vue';
import Router from 'vue-router';

Vue.use(Router);

const router = new Router({
    routes: [
        {
            path: '/',
            name: 'Landing Page',
            component: require('@/components/Login').default,
            meta: {
                isGuestRoute: true,
            },
        },
        {
            path: '/login',
            name: 'Login',
            component: require('@/components/Login').default,
            meta: {
                isGuestRoute: true,
            },
        },
        {
            path: '/register',
            name: 'Register',
            component: require('@/components/Register').default,
            meta: {
                isGuestRoute: true,
            },
        },
        {
            path: '/chat',
            name: 'Chat',
            component: require('@/components/Chat').default,
            meta: {
                requiresAuth: true,
            },
        },
    ],
});

/*
router.beforeEach((to, from, next) => {
    if (to.matched.some(record => record.meta.requiresAuth)) {
        router.app.$localStorage.has('jwt', (error, hasKey) => {
            if (hasKey) {
                next();
            } else {
                next({
                    path: '/login',
                    params: { nextUrl: to.fullPath },
                });
            }
        });
    } else if (to.matched.some(record => record.meta.isGuestRoute)) {
        router.app.$localStorage.has('jwt', (error, hasKey) => {
            if (hasKey) {
                next({
                    path: '/chat',
                    params: { nextUrl: to.fullPath },
                });
            } else {
                next();
            }
        });
        next({ name: '' });
    } else {
        next();
    }
});
*/

export default router;
