import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';

import { Task } from './task';
import { ParentTask } from './ParentTask';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};


@Injectable()
export class TaskService {

  private taskUrl = "http://localhost:8080"; 
  

  public task = null;
  public editTaskFlag = false;
  

  constructor(private http: HttpClient) { }

  addTask (task: Task): Observable<void> {    
   
    return this.http.post<any>(this.taskUrl+"/task", task, httpOptions).pipe(
      tap(() => this.log(`added task`)),
      catchError(this.handleError<Task>('addHero'))
    );
  }
  addParentTask (task: Task): Observable<void> {    
   
    return this.http.post<any>(this.taskUrl+"/parenttask", task, httpOptions).pipe(
      tap(() => this.log(`added task`)),
      catchError(this.handleError<Task>('addHero'))
    );
  }

  getParentTask(): Observable<ParentTask[]>{
	return this.http.get<ParentTask[]>(this.taskUrl+"/parenttask")
      .pipe(
        tap(parentTasks => this.log(`fetched parentTasks`)),
        catchError(this.handleError('getParentTask', []))
      );
  }

  getAllTasks(): Observable<Task[]>{
    return this.http.get<Task[]>(this.taskUrl+"/task")
        .pipe(
          tap(Task => this.log(`fetched allTasks`)),
          catchError(this.handleError('getallTask', []))
        );
    }

  getTasksByProject(id: number): Observable<Task[]>{
  return this.http.get<Task[]>(this.taskUrl+"/task/"+id)
      .pipe(
        tap(Tasks => this.log(`fetched Tasks`)),
        catchError(this.handleError('getTasks', []))
      );
  }

  editTask (task: Task): Observable<any> {
    return this.http.put(this.taskUrl + "/task", task, httpOptions).pipe(
      tap(_ => this.log(`updated task`)),
      catchError(this.handleError<any>('updateUser'))
    );
  }
  updateTaskStatus(taskid: number): any {
    return this.http.put(this.taskUrl + "/task/"+taskid, httpOptions).pipe(
      tap(_ => this.log(`deleted task `)),
      catchError(this.handleError<any>('update Task Status'))
    );
  }

 


  getAllCompletedTask(): Observable<Task[]>{
    return this.http.get<Task[]>(this.task+"/task/allTaskcompleted")
        .pipe(
          tap(Task => this.log(`fetched allCompletedTasks`)),
          catchError(this.handleError('getallCompletedTask', []))
        );
    }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };

  }

  private log(message: string) {
    //console.log(message);
    //TODO: send the error to remote logging infrastructure
  }

}
