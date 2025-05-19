import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ClientService } from '../../services/client.service';

@Component({
  selector: 'app-client',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './client.component.html',
  styleUrl: './client.component.css'
})
export class ClientComponent implements OnInit {
  clients: any[] = [];
  loading = false;
  error: string | null = null;
  
  constructor(private clientService: ClientService) { }

  ngOnInit() {
    this.getClients();
  } 

  getClients() {
    this.loading = true;
    this.error = null;
    
    this.clientService.getClients().subscribe({
      next: (clients: any) => {
        this.clients = clients;
        this.loading = false;
      },
      error: (err) => {
        this.error = 'Erreur lors du chargement des clients: ' + err.message;
        this.loading = false;
        console.error('Error fetching clients:', err);
      }
    });
  }
}
