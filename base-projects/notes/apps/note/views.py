from django.http import JsonResponse
from django.shortcuts import get_object_or_404
from django.views.decorators.csrf import csrf_exempt

from .models import Note
from .forms import NoteCreateForm


def note_list(request):
    if not request.user.is_authenticated:
        return JsonResponse({'message': "User is not logged in"})

    notes = Note.objects.filter(user=request.user)
    data = [{'id': note.id, 'title': note.title, 'body': note.body,
             'create_time': note.create_time} for note in notes]
    return JsonResponse(data, safe=False)


def note_detail(request, pk):
    if not request.user.is_authenticated:
        return JsonResponse({'message': "User is not logged in"})

    note = get_object_or_404(Note, pk=pk, user=request.user)
    data = {'id': note.id, 'title': note.title,
            'body': note.body, 'create_time': note.create_time}
    return JsonResponse(data)


@csrf_exempt
def note_create(request):
    if not request.user.is_authenticated:
        return JsonResponse({'message': "User is not logged in"})

    form = NoteCreateForm(request.POST)
    if form.is_valid():
        note = form.save(commit=False)
        note.user = request.user
        note.save()
        data = {'id': note.id, 'title': note.title,
                'body': note.body, 'create_time': note.create_time}
        return JsonResponse(data)
    else:
        return JsonResponse({'error': 'Invalid data'}, status=400)


def note_delete(request, pk):
    if not request.user.is_authenticated:
        return JsonResponse({'message': "User is not logged in"})

    note = get_object_or_404(Note, pk=pk, user=request.user)
    note.delete()
    return JsonResponse({'message': 'Note deleted successfully'})
