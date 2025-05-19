import { Routes } from '@angular/router';
import { ClientComponent } from './components/client/client.component';
import { CreditComponent } from './components/credit/credit.component';
import { RemboursementComponent } from './components/remboursement/remboursement.component';

export const routes: Routes = [
    {
        path: '',
        component: ClientComponent
    },
    {
        path: 'client',
        component: ClientComponent
    },
    {
        path: 'credit',
        component: CreditComponent
    },
    {
        path: 'remboursement',
        component: RemboursementComponent
    }
];
